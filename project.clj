(defproject clojure-protobuf-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [com.google.protobuf/protobuf-java "3.0.0"]
                 [org.flatland/protobuf "0.8.2-SNAPSHOT"]]
  :plugins [[lein-protobuf "0.5.0"]]
  :protoc "/home/dfornika/bin/protoc"
  :main ^:skip-aot clojure-protobuf-test.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
