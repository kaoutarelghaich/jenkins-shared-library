#!/usr/bin/env groovy

def call() {
    echo "Building the application"
    sh '''
        python3 -m venv .venv
        . .venv/bin/activate
        make install
        make build
    '''
}