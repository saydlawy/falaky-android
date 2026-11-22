#!/usr/bin/env bash
# Run once in a GitHub Codespace (browser terminal). Creates the release signing key and prints
# the base64 to paste into the FALAKY_KEYSTORE_BASE64 repository secret.
# Keep the .jks and passwords backed up OFFLINE: Android refuses updates signed with a different key.
set -euo pipefail
read -r -s -p "Choose a keystore/key password (min 8 chars): " PW; echo
OUT=/tmp/falaky-release.jks
keytool -genkeypair -v -keystore "$OUT" -alias falaky -keyalg RSA -keysize 4096 -validity 10000 \
  -storepass "$PW" -keypass "$PW" -dname "CN=Falaky, O=Falaky, C=KW"
echo
echo "== Secrets to add (Settings > Secrets and variables > Actions) =="
echo "FALAKY_KEYSTORE_PASSWORD = the password you typed"
echo "FALAKY_KEY_PASSWORD      = the same password"
echo "FALAKY_KEY_ALIAS         = falaky"
echo "FALAKY_KEYSTORE_BASE64   = (printed below, one long line)"
echo
base64 -w0 "$OUT"; echo
echo
echo "Now download $OUT from the Codespace file explorer for backup, then delete the Codespace."
