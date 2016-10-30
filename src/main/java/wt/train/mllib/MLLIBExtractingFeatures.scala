package wt.train.mllib

import org.apache.spark.mllib.feature.{HashingTF, StandardScaler, StandardScalerModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.feature.{HashingTF, IDF}
import org.apache.spark.mllib.linalg.Vector
import org.apache.spark.rdd.RDD

/**
  * Created by kisilnazar on 22.10.16.
  */
object MLLIBExtractingFeatures {

  def main(args: Array[String]) {

    val conf = new SparkConf().setAppName("MLLIBExampleApp")
    val sc = new SparkContext(conf)

    val dataF = sc.textFile("data/mllib/avito_train.tsv")
      .map(_.split(" ").toSeq)

    val hashingTF = new HashingTF()
    val tf: RDD[Vector] = hashingTF.transform(dataF)

    val scaler1 = new StandardScaler().fit(tf)
    val scaler2 = new StandardScaler(withMean = true, withStd = true).fit(tf)
    // scaler3 is an identical model to scaler2, and will produce identical transformations
    val scaler3 = new StandardScalerModel(scaler2.std, scaler2.mean)

    sc.stop()
  }
}