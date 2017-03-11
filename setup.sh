#!/bin/sh

if ! type "brew" 2>&1 /dev/null; then
  echo "brew not installed"
else
  echo "brew installed"
fi