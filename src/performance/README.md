# Performance Testing

## Tool
Apache JMeter 5.6.3

## Test Scenario
Load testing of the Banking Application login page.

## Endpoint
GET https://qaplayground.com/bank/login

## Current Test Configuration
- Virtual Users: 50
- Ramp-Up Period: 10 seconds
- Loop Count: 10
- Total Requests: 500

## Metrics
The test measures:
- Average response time
- Minimum response time
- Maximum response time
- Throughput
- Error percentage
- Number of requests

## Test Plan
banking-login-load-test.jmx