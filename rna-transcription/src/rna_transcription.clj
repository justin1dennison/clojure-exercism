(ns rna-transcription
  (:require [clojure.set :as set]))

(def transcribe {\G \C \C \G \T \A \A \U})
(defn valid? [strand] 
  (set/subset? (set strand) #{\G \C \T \A}))

(defn to-rna [dna]
  (assert (valid? dna))
  (->> dna
       (map transcribe)
       (apply str)))
    


  
