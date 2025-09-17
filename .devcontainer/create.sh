#!/bin/bash

# DevContainer creation script
set -e

echo "Setting up development environment..."

# Update package lists
sudo apt-get update

# Install additional dependencies if needed
# sudo apt-get install -y <package-name>

# Install chrome
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt install ./google-chrome-stable_current_amd64.deb -y
rm google-chrome-stable_current_amd64.deb

# Set up any custom configurations
echo "Development environment setup complete!"
