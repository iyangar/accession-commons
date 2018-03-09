package uk.ac.ebi.eva.benchmarking_suite

object RandomEntityIDGenerator {

  def getRandomEntityID (randomNumGen: scala.util.Random): String = {
    // Construct entity to look up based on a random combination of entity ID components
    // described in @uk.ac.ebi.eva.benchmarking_suite.mongodb.MongoDBWriteSampler
    val numThreadChoices = ReadBenchmarkingConstants.threadChoices.length
    val randomThreadChoice = ReadBenchmarkingConstants.threadChoices(randomNumGen.nextInt(numThreadChoices))
    val randomThreadNum = randomNumGen.nextInt(randomThreadChoice)

    "ent_%d_%d_%d_%d".format(
      randomThreadChoice,
      randomThreadNum,
      randomNumGen.nextInt(ReadBenchmarkingConstants.numLoopsUB) + 1, //JMeter iteration indices start from 1
      randomNumGen.nextInt(ReadBenchmarkingConstants.numRecordsUB/ReadBenchmarkingConstants.threadChoiceUB)
    )
  }

}
