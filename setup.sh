#!/bin/sh

if ! type "brew" >/dev/null 2>&1; then
  echo "brew not installed"
else
  echo "brew installed"
fi