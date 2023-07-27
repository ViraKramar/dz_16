pipeline {
    agent any
    tools {
        maven 'maven_3_9_3'
        jdk 'JDK-17'
    }
    stages{
        stage("Checking Build Number"){
            steps{
                echo "Build number = $env.BUILD_NUMBER"
            }
        }
        stage("Run test with withMaven option"){
        steps{
        withMaven(maven: 'maven_3_9_3', jdk: 'JDK_17'){
            sh 'mvn clean test'
                }
            }
        }
    }
    post{
        always{
            allure([
            includeProperties: false,
            jdk: '',
            properties: [],
            reportBuildPolicy: 'ALWAYS',
            results: [[path: 'target/allure-results']]
            ])
        }
    }
}
