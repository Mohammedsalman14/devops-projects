def gv
pipeline {
    
    agent any
    tools {
        maven 'Maven'
    }
    parameters {
    choice(name: 'Version', choices: ['1.1', '1.2', '1.3'], description: 'Select the version')
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
