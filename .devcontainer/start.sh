#!/bin/bash

# DevContainer starting script
set -e

echo "Starting up development environment..."

# Update chrome
sudo apt install google-chrome-stable -y

# Open chrome in the background
# google-chrome --no-sandbox &

# Set up any custom configurations
echo "Development environment startup complete!"
