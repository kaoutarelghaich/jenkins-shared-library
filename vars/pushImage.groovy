#!/usr/bin/env groovy

def call(imageName) {
    withCredentials ([
        usernamePassword(
            credentialsId: 'docker-hub',
            usernameVariable: 'USER',
            passwordVariable: 'TOKEN'
        )
    ]) {
        sh 'set +x; printf "%s" "$TOKEN" | docker login -u "$USER" --password-stdin'
        sh "docker push $imageName"
    }
}