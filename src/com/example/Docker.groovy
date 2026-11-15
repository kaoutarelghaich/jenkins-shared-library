#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building Docker image: $imageName"
        script.sh "docker build -t $imageName ."
    }


    def dockerLogin() {
        script.withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        script.sh "docker login -u $script.DOCKER_USER -p $script.DOCKER_PASS"
        }
    }

    def pushDockerImage(String imageName) {
            script.sh "docker push $imageName"
        }
    }