def call(){
    dependencyCheck additionalArguments: '--scan ./', odcInstallation: 'OWASP'
    dependencyCheckPublisher pattern: '**/dependency-check-report.xml', failBuildOnCVSS: 7, unstableTotalAll: 10
}