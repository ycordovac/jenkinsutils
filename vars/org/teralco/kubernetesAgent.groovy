def call(Map config = [:]) {
    String cloud = 'kubernetes'

    def ret = [:]

    def agentCreator = renderTemplateText(templatePath:'./org//teralco/agentTemplate/kubernetesAgent.tpl',
        tokens: [
            imageName: config.imageName,
            credentialSecret: config.credentialSecret
        ])

    ret['cloud'] = cloud
    ret['yaml'] = agentCreator

    return ret
}