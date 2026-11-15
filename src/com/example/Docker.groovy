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
        script.withCredentials([
            script.usernamePassword(
                credentialsId: 'docker-hub',
                usernameVariable: 'DOCKER_USER',
                passwordVariable: 'DOCKER_PASS'
            )
        ]) {
            script.sh '''
                echo "$DOCKER_PASS" | docker login \
                    -u "$DOCKER_USER" --password-stdin
            '''
        }
    }


    def pushDockerImage(String imageName) {
            script.sh "docker push $imageName"
        }
    }