#!/bin/bash
git branch -a
git add .
read -p "Commit description: " desc
git commit -m "$desc"
echo 'remote branch'
read remote
echo 'your remote brach is's $remote
git push origin $remotecd #!/usr/bin/env bash
