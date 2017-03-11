#!/bin/sh

if [ -z `brew -v | grep "command not found"`]; then
    echo "brew installed"
else
    echo "brew not installed"
fi