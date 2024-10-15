pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                // Command to build the project
                sh './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                // Command to run tests
                sh './gradlew test'
            }
        }
    }

    post {
        always {
            // Notify that the build is done
            echo 'Build and tests completed.'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
