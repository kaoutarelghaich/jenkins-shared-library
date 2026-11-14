#!/usr/bin/env groovy

def call() {
    echo 'Building the Docker image'
    sh 'docker build -t koukidevops/taskops-api:1.0 .'
}