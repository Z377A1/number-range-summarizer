#!/bin/bash

set -e

echo "Running tests..."
./mvnw clean test
echo "Test completed successfully!"
echo ""
echo "Reports for tests generated successfully!"
echo "Reports are located at target/surefire-reports"
