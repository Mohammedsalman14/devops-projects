pipeline {
    
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo 'building the application'
                    sh 'mvn package'
            }}
            }
        stage('build-dockerimage') {
            steps {
                    script {
                        echo 'build the docker image...'
                        withCredentials([usernamePassword(credentialsId:'dockerhub-repo', usernameVariable:'USER', passwordVariable:'PASSWD')]) {

                            sh 'docker build -t salman14/mydevfirst:2.0 .'
                            sh "echo $PASSWD | docker login -u $USER --password-stdin  "
                            sh 'docker push salman14/mydevfirst:2.0'
                }}
                    }
            }
        stage('deploy') {
            steps {
                script {
                    echo 'deploying the application'
                }
        }}
        }
        }
