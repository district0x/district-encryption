# district-encryption

[![Build Status](https://travis-ci.org/district0x/district-encryption.svg?branch=master)](https://travis-ci.org/district0x/district-encryption)

Set of functions helpful for data encryption on blockchain based on public/private key. This library utilises [eccjs](https://github.com/jpillora/eccjs). Suitable for both nodejs and browser.

## Installation ##

Add <br>
[![Clojars Project](https://img.shields.io/clojars/v/district0x/district-encryption.svg)](https://clojars.org/district0x/district-encryption)
into your project.clj <br>

Include `[district.encryption]` in your CLJS file.

# district.encryption #

#### `generate-keypair []` ####

Generates and returns public/private keypair. 

#### `encrypt [public-key content]` ####

Encrypts content with public key.

#### `decrypt [private-key content]` ####

Decrypts content with private key.

#### `encode-base64 [string]` ####

Base64 encodes string.

#### `decode-base64 [string]` ####

Base64 decodes string.

#### `encrypt-encode [public-key content]` ####

Encrypts with public key and then base64 encodes.

#### `decode-decrypt [private-key content]` ####

Base64 decodes and then decrypts with private key.
