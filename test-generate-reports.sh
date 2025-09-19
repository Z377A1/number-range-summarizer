#!/bin/bash

set -e

echo "Generating reports for tests..."
./mvnw surefire-report:report-only

echo "Opening html report in browser..."
google-chrome --no-sandbox ./target/reports/surefire.html &
