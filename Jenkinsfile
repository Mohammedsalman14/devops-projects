def gv

@Library('jenkins-shared-library')_

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    parameters {
        choice(name: 'Version', choices: ['1.1', '1.2', '1.3'], description: 'Select the version')
    }

    stages {
        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }
        stage('build') {
            when {
                        expression {
                            params.Version
                        }
            }
            steps {
                script {
                    buildJar()
            }}
            }
        stage('build-dockerimage') {
            steps {
                    script {
                        buildImage 'salman14/mydevfirst:3.0'
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
