(ns accumulate)

(defn accumulate [f coll]
  (for [el coll] (f el)))
