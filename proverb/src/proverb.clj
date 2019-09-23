(ns proverb
  (:require [clojure.string :as str]))

(defn line [[l r]]
  (format "For want of a %s the %s was lost." l r))

(defn end [word]
  (format "And all for the want of a %s." word))

(defn recite [words]
  (let [fst       (first words)
        chunks    (partition 2 1 words)
        beginning (map line chunks)
        ending    (end fst)]
    (if (empty? words)
      ""
      (str/join
       "\n"
       (conj (into [] beginning) ending)))))





