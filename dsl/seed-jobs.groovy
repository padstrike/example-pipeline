folder("project-a")
['dev', 'sit', 'uat'].each { env ->
    def jenkinsfileName = "project-a/${env}.Jenkinsfile"
    pipelineJob("project-a/${env}") {
        definition {
        cpsScm {
            scm {
            git {
                remote { url("https://github.com/padstrike/example-pipeline.git") }
                branches("*/main")
            }
            }
            scriptPath(jenkinsfileName)
        }
        }
    }
}