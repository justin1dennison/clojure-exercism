(ns two-fer)


(defn get-name [args]
  (if (nil? args)
    "you"
    (first args)))

(defn two-fer [& args] 
  (str "One for " (get-name args) ", one for me."))
