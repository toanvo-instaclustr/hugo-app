mavenJob('Build Hugo App (DSL)') {
    description 'Build job for Hugo App'

    logRotator {
        numToKeep 5
    }

    parameters {
        gitParam('Branch') {
            description 'The Git branch to checkout'
            type 'BRANCH'
            defaultValue 'origin/main'
        }
    }

    scm {
        git {
            remote {
                url 'git@github.com:toanvo-instaclustr/hugo-app.git'
            }

            branch '$Branch'
        }
    }

    triggers {
        scm 'H/15 * * * *'
        snapshotDependencies true
    }

    rootPOM 'pom.xml'
    goals 'clean install'
}