(ns district.encryption
  (:require
    [cljsjs.eccjs :as eccjs]
    [goog.crypt.base64 :as base64]))

(when (= (str js/process) "[object process]")               ;; node environment
  (set! js/ecc (js/require "eccjs")))

(defn generate-keypair []
  (let [keypair (js->clj (.generate js/ecc (.-ENC_DEC js/ecc) 256))]
    {:public-key (get keypair "enc")
     :private-key (get keypair "dec")}))

(defn encrypt [public-key content]
  (.encrypt js/ecc public-key content))

(defn decrypt [private-key content]
  (.decrypt js/ecc private-key content))

(defn encode-base64 [s]
  (base64/encodeString s))

(defn decode-base64 [s]
  (base64/decodeString s))

(defn encrypt-encode [public-key content]
  (try  (->> content
             (encrypt public-key)
             (encode-base64))
        (catch js/Object e
          (throw
           (ex-info "Exception encrypting content"
                    {:cause (ex-message e)})))))

(defn decode-decrypt [private-key content]
  (try
    (->> content
         (decode-base64)
         (decrypt private-key))
    (catch js/Object e
      (throw
       (ex-info "Exception decoding content"
                {:cause (ex-message e)})))))
