#!/usr/bin/env bash
/Users/kisilnazar/Development/Tools/spark-2.0.0-bin-hadoop2.7/bin/spark-submit \
  --class "wt.train.mllib.MLLIBExtractingFeatures" \
  --master local[4] \
  target/scala-2.11/spark-mllib-train_2.11-1.0.jar