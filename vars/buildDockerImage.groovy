def call(Map args) {
	def customImage = docker.build("${args.repositoryURL}:${args.imageVersion}", "--no-cache=true --force-rm --file Dockerfile .")
	customImage.push()
	customImage.push('latest')
	sh "docker rmi ${args.repositoryURL}:${args.imageVersion}"
	echo "Finished creation of docker images and pushed to GCR"
}