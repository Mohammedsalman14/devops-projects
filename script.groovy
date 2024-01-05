def buildJar() {
    echo 'building the application'
    sh 'mvn package'
}
def buildImage() {
    echo 'build the docker image...'
    withCredentials([usernamePassword(credentialsId:'dockerhub-repo', usernameVariable:'DOCKER_USER', passwordVariable:'DOCKER_PASSWD')]) {
        sh 'docker build -t salman14/mydevfirst:2.0 .'
        sh "echo $DOCKER_PASSWD | docker login -u $DOCKER_USER --password-stdin  "
        sh 'docker push salman14/mydevfirst:2.0'
    }
}
def deployApp() {
    echo 'deploying the application'
}

return this