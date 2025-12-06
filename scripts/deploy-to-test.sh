#!/usr/bin/env bash
set -euo pipefail
IMAGE=${IMAGE:-"ghcr.io/${GITHUB_REPOSITORY_OWNER}/calculator:${GITHUB_SHA}"}

echo "Stopping any existing container..."
docker rm -f calculator-test || true

echo "Running image ${IMAGE} on port 8080..."
docker run -d --name calculator-test -p 8080:8080 ${IMAGE}
echo "App should now be available at http://localhost:8080"