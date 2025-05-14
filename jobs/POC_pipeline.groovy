folder('POC') {
  displayName('POC')
  description('Folder for Proof of Concept jobs')
}

pipelineJob('POC/DemoPipeline') {
  description('POC mock pipeline job for testing JCasC + Job DSL')
  definition {
    cps {
      script('''\
        pipeline {
          agent any
          stages {
            stage('Init') {
              steps {
                echo 'Preparing environment...'
              }
            }
            stage('Build') {
              steps {
                echo 'Running mock build...'
              }
            }
            stage('Test') {
              steps {
                echo 'Executing mock tests...'
              }
            }
          }
        }
      '''.stripIndent())
      sandbox(true)
    }
  }
  disabled(false)
}
