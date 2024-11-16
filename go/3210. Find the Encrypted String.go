func getEncryptedString(s string, k int) string {
	var sb strings.Builder
	for i := range s {
		encoded := s[(i+k)%len(s)]
		sb.WriteByte(encoded)
	}
	return sb.String()
}