package com.microservice.service_A.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class serviceAController {

    @Autowired
    private WebClient.Builder webclient;

    private static final String url = "http://localhost:8084/serviceB/getServiceB";

    @GetMapping("/getServiceA")

    /*
     * RETRY
     * -----
     * Purpose:
     * - Automatically retries a failed method call.
     *
     * When is it useful?
     * - Temporary network issues
     * - Service is momentarily unavailable
     * - Database connection timeout
     *
     * Example:
     * max-attempts = 3
     *
     * Call 1 ❌
     * Retry 1 ❌
     * Retry 2 ✅
     *
     * If ALL retries fail, then the fallback() method is invoked.
     */
    @Retry(name = "serviceB", fallbackMethod = "fallback")

    /*
     * CIRCUIT BREAKER
     * ----------------
     * Purpose:
     * - Stops calling an unhealthy service after repeated failures.
     *
     * States:
     * CLOSED
     *   Normal state.
     *   Every request goes to Service B.
     *
     * OPEN
     *   Failure threshold exceeded.
     *   No requests are sent to Service B.
     *   fallback() is called immediately.
     *
     * HALF_OPEN
     *   After waitDurationInOpenState.
     *   Allows a few trial requests.
     *   If they succeed -> CLOSED.
     *   If they fail -> OPEN again.
     *
     * Why use it?
     * - Prevents wasting resources repeatedly calling a failing service.
     * - Protects downstream services from overload.
     */
    @CircuitBreaker(name = "serviceB", fallbackMethod = "fallback")

    /*
     * RATE LIMITER
     * ------------
     * Purpose:
     * - Limits how many requests are allowed in a given time period.
     *
     * Example:
     * limit-for-period = 5
     * limit-refresh-period = 10s
     *
     * First 5 requests -> Allowed ✅
     * 6th request -> Rejected ❌
     * fallback() is called.
     *
     * Counter resets after 10 seconds.
     *
     * Mainly used for:
     * - Public APIs
     * - Preventing abuse
     * - Preventing traffic spikes
     */
    @RateLimiter(name = "serviceB", fallbackMethod = "fallback")

    public String getMethod() {
        return webclient.build()
                .get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    /*
     * Common fallback method
     *
     * Executed when:
     * - Retry exhausts all attempts
     * - Circuit Breaker is OPEN
     * - Rate Limiter rejects the request
     *
     * The Exception parameter contains the actual cause:
     * - WebClientResponseException
     * - CallNotPermittedException (Circuit Breaker)
     * - RequestNotPermitted (Rate Limiter)
     * etc.
     */
    public String fallback(Exception ex) {
        return "Service B is currently unavailable.";
    }
}