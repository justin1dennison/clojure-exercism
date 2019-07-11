(ns phone-number)

(def default "0000000000")

(defn strip [coll chars]
  (apply str (remove (set chars) coll)))

(defn starts-with? [start x]
  (= (first x) start))

(defn number [num-string]
  (let [n (strip num-string "- ( ) .")]
    (cond
      (and
       (= (count n) 11)
       (starts-with? \1 n)) (subs n 1)
      (= (count n) 10) n
      :else default)))

(defn area-code [num-string]
  (subs (number num-string) 0 3))

(defn- prefix [num-string]
  (subs (number num-string) 3 6))

(defn- line-number [num-string]
  (subs (number num-string) 6))

(defn pretty-print [num-string]
  (format "(%s) %s-%s"
          (area-code num-string)
          (prefix num-string)
          (line-number num-string)))
