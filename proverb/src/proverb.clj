(ns proverb
  (:require [clojure.string :as str]))

(defn recite [words]
  (let [fst             (first words)
        chunks          (partition 2 1 words)
        beginning-parts (for [[l r] chunks] (format "For want of a %s the %s was lost." l r))
        ending          (format "And all for the want of a %s." fst)]
    (if (empty? words)
      ""
      (str/join
       "\n"
       (conj (into [] beginning-parts) ending)))))





