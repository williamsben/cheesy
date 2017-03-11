#!/bin/sh

echo "Checking for Homebrew..."
command -v brew >/dev/null && echo "Homebrew installed." || {
    echo "Homebrew not installed.";
    echo "Installing Homebrew";
}