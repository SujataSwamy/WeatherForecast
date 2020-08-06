#!/bin/bash

# Firebase service account decrypt
- openssl aes-256-cbc -K $encrypted_6ccb8a696b2d_key -iv $encrypted_6ccb8a696b2d_iv -in weatherforecast-d2654-4cca52839c71.json.enc -out /tmp/weatherforecast-d2654-4cca52839c71.json -d


# Firebase setup
wget --quiet --output-document=/tmp/google-cloud-sdk.tar.gz https://dl.google.com/dl/cloudsdk/channels/rapid/google-cloud-sdk.tar.gz  
mkdir -p /opt  
tar zxf /tmp/google-cloud-sdk.tar.gz --directory /opt  
/opt/google-cloud-sdk/install.sh --quiet
source /opt/google-cloud-sdk/path.bash.inc

# Setup and configure the project
gcloud components update  
echo weatherforecast-d2654
gcloud config set project weatherforecast-d2654

# Activate cloud credentials

  - gcloud auth activate-service-account weatherforecastdemo@weatherforecast-d2654.iam.gserviceaccount.com --key-file=/tmp/weatherforecast-d2654-4cca52839c71.json --project=weatherforecast-d2654

# List available options for logging purpose only (so that we can review available options)

gcloud firebase test android models list
gcloud firebase test android versions list

./gradlew build assembleDebug
gcloud firebase test android run --app app/build/outputs/apk/debug/app-debug.apk --type=robo --device model=Nexus4,version=19





