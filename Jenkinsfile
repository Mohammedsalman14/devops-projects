def gv
pipeline {
    
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage('init'){
            steps{
                script{
                    gv=load "script.groovy"
                }
            }
        }
        stage('build') {
            steps {
                script {
                    gv.buildJar()
            }}
            }
        stage('build-dockerimage') {
            steps {
                    script {
                            gv.buildImage()
                        }
                    }
            }
        stage('deploy') {
            steps {
                script {
                    gv.deployApp()
                }
        }}
        }
        }
