def buildJar() {
    echo 'building the application'
    sh 'mvn package'
}
def buildImage() {
    echo 'build the docker image...'
    withCredentials([usernamePassword(credentialsId:'dockerhub-repo', usernameVariable:'USER', passwordVariable:'PASSWD')]) {
        sh 'docker build -t salman14/mydevfirst:2.0 .'
        sh "echo $PASSWD | docker login -u $USER --password-stdin  "
        sh 'docker push salman14/mydevfirst:2.0'
    }
}
def deployApp() {
    echo 'deploying the application'
}
