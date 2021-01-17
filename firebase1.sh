#!/bin/bash

# Firebase service account decrypt
#- openssl aes-256-cbc -K $encrypted_6ccb8a696b2d_key -iv $encrypted_6ccb8a696b2d_iv -in weatherforecast-d2654-4cca52839c71.json.enc -out /tmp/weatherforecast-d2654-4cca52839c71.json -d

# Firebase setup
#wget --quiet --output-document=/tmp/google-cloud-sdk.tar.gz https://dl.google.com/dl/cloudsdk/channels/rapid/google-cloud-sdk.tar.gz
#mkdir -p /opt
#tar zxf /tmp/google-cloud-sdk.tar.gz --directory /opt
#/opt/google-cloud-sdk/install.sh --quiet
#source /opt/google-cloud-sdk/path.bash.inc

# Setup and configure the project
#gcloud components update
#echo weatherforecast-d2654
#gcloud config set project weatherforecast-d2654

# Activate cloud credentials
#gcloud auth activate-service-account --key-file /tmp/weatherforecast-d2654-4cca52839c71.json

# List available options for logging purpose only (so that we can review available options)
#gcloud firebase test android models list
#gcloud firebase test android versions list
#
#./gradlew build assembleDebug


./gradlew ktlintFormat
#readonly GIT_HAS_CHANGES=1 # 0 = clean, 1 = dirty
#
#git diff --quiet; GIT_DIFF_STATUS=$?
#
#
#
## If the GIT_DIFF_STATUS is 1 (GIT_HAS_CHANGES) then we know
## there are changes and we can commit the changes and push
## them to new branch
#CURRENT_BRANCH=$(git branch)
#if [[ ${GIT_DIFF_STATUS} -eq ${GIT_HAS_CHANGES} ]]; then
#    DAY=$( date +%b-%d-%Y )
#    BRANCH_NAME="bot/$DAY/code-formatting"
#
#    git checkout -b "$BRANCH_NAME"
#    git commit -am "$BRANCH_NAME"
#    git push -u origin "$BRANCH_NAME"
#
#    echo "::set-output name=branch_name::${BRANCH_NAME}"
#fi





#!/usr/bin/env bash

readonly GIT_HAS_CHANGES=1 # 0 = clean, 1 = dirty

#USER_NAME="$1"
#USER_EMAIL="$2"

git config --global user.email "sujatagopalswamy@gmail.com"
  git config --global user.name "sujataswamy"

#git config user.name "$USER_NAME"
#git config user.email "$USER_EMAIL"

# Following git command checks the git diff of staged files
# and assigns the exit code to GIT_DIFF_STATUS variable.
git diff --quiet; GIT_DIFF_STATUS=$?

# If the GIT_DIFF_STATUS is 1 (GIT_HAS_CHANGES) then we know
# there are changes and we can commit the changes and push
# them to new branch
if [[ ${GIT_DIFF_STATUS} -eq ${GIT_HAS_CHANGES} ]]; then
    DAY=$( date +%b-%d-%Y )
    BRANCH_NAME="bot/$DAY/code-formatting"


    git checkout -b "$BRANCH_NAME"
    git commit -am "[BOT] Code formatting fixes"
    git push -u origin "$BRANCH_NAME"

    echo "::set-output name=branch_name::${BRANCH_NAME}"
fi


#gcloud firebase test android run --app app/build/outputs/apk/debug/app-debug.apk --type=robo --device model=Pixel2,version=28






