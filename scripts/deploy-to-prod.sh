#!/usr/bin/env bash
set -euo pipefail
IMAGE=${IMAGE:-"ghcr.io/${GITHUB_REPOSITORY_OWNER}/calculator:latest"}

echo "Stopping existing prod container..."
docker rm -f calculator-prod || true

echo "Running image ${IMAGE} on port 8080..."
docker run -d --name calculator-prod -p 8080:8080 ${IMAGE}
echo "Production app available at http://localhost:8080"