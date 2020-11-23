properties([[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', artifactDaysToKeepStr: '10', artifactNumToKeepStr: '30', daysToKeepStr: '365', numToKeepStr: '']]]);
timestamps {
    node('master'){
        workspace = pwd()
        // Mark the code checkout 'stage'....
        stage('Checkout'){
            // Get some code from a GitHub repository
            checkout scm
        }
        stage('Clone'){
            sh '''
            BRANCH_CLEAN=$(echo $BRANCH_NAME | sed \'s#feature/##g\' | perl -pe \'s/[^\\w]+//g\' | perl -pe \'s/$//g\')
            VERSION=$(date +%Y.%m.%d)
            export BRANCH_CLEAN
            ls -la
            cat /etc/centos_release
            '''

        }

        stage('Test'){

            sh './gradlew clean test --no-daemon'


        }

    }
}