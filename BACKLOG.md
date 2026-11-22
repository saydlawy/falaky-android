# Backlog

## Now (stage 1, scaffold)
- [ ] First CI run is green
- [ ] Commit generated Room schema (core/database/schemas/1.json) from the `room-schemas` CI artifact
- [ ] Create signing key and secrets (docs/SETUP.md), tag v0.1.0, confirm the release APK installs on a TV

## Stage 2 core playback
- [ ] Xtream auth + stream URLs, Media3 player (live/VOD/series), error and retry

## Stage 3 catalog sync
- [ ] One sync pipeline for live, movies, series, categories, EPG (XMLTV streamed)
- [ ] categoryId overwritten on every resync, orphans removed by generation stamp
- [ ] Shared catalog (Firestore) separate from local browse DB

## Stage 4 Netflix-style TV UI
- [ ] Hero banner, paged rails (no hidden caps), details with seasons/episodes, D-pad focus, AR/EN

## Stage 5 accounts, keys, updater
- [ ] Firebase (Spark): email + Google sign-in, QR pairing via Firestore handshake
- [ ] Firestore rules: users/{uid}/** owner only, admin read, catalog read all / write admin only; rules tests in CI
- [ ] Per-user TMDB + Gemini keys (device only, encrypted)
- [ ] In-app updater from GitHub Releases with SHA-256 + signature check

## Later
- [ ] Profiles + PIN
- [ ] Phone pairing for key entry
