# Setup without any local tools

1. Upload the project files to the repo (GitHub web: Add file > Upload files, drag the unzipped folder contents, commit to main). Make sure `.github`, `gradle/wrapper/gradle-wrapper.jar` and `gradlew` are included.
2. Open the Actions tab and wait for the CI run. Fix any red step before going on.
3. Signing key: open the repo > Code > Codespaces > Create codespace. In its terminal run `bash scripts/make-keystore.sh`. Add the four printed secrets in Settings > Secrets and variables > Actions. Download the `.jks` for backup, then delete the Codespace.
4. Release: Releases > Draft a new release > create tag `v0.1.0` on main > Publish (or `git tag v0.1.0 && git push --tags`). The Release workflow builds the signed APK and attaches it plus a `.sha256`.
5. Install: download the APK from the release page on the TV (Downloader app) or on a phone then send it to the TV.
