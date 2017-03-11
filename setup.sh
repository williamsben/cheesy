#!/bin/sh

if ! type "brew" > /dev/null; then
  echo "brew not installed"
else
  echo "brew installed"
fi